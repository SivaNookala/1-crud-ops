package com.wellsfargo.tts.api.controller;

import com.google.api.gax.core.CredentialsProvider;
import com.google.cloud.texttospeech.v1.*;
import com.google.protobuf.ByteString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class TTSController {

    @Autowired
    private CredentialsProvider credentialsProvider;

    @GetMapping("/hello")
    public String hello() {
        return "Hello TTS API";
    }

    @GetMapping("/textToSpeech")
    public byte[] convertTextToSpeech(@RequestParam("text") String text) throws IOException {
        TextToSpeechSettings textToSpeechSettings = TextToSpeechSettings.newBuilder()
                .setCredentialsProvider(credentialsProvider).build();

        TextToSpeechClient textToSpeechClient = TextToSpeechClient.create(textToSpeechSettings);

        // Set the text input to be synthesized
        SynthesisInput input = SynthesisInput.newBuilder().setText(text).build();

        // Build the voice request
        VoiceSelectionParams voice =
                VoiceSelectionParams.newBuilder()
                        .setLanguageCode("en-US") // languageCode = "en_us"
                        .setSsmlGender(SsmlVoiceGender.FEMALE) // ssmlVoiceGender = SsmlVoiceGender.FEMALE
                        .build();

        // Select the type of audio file you want returned
        AudioConfig audioConfig =
                AudioConfig.newBuilder()
                        .setAudioEncoding(AudioEncoding.MP3) // MP3 audio.
                        .build();

        // Perform the text-to-speech request
        SynthesizeSpeechResponse response =
                textToSpeechClient.synthesizeSpeech(input, voice, audioConfig);

        // Get the audio contents from the response
        ByteString audioContents = response.getAudioContent();

        return  audioContents.toByteArray();
    }

    @GetMapping("/saveMp3")
    public Boolean saveMp3(@RequestParam("text") String text) throws IOException {
        byte[] audioContents = convertTextToSpeech(text);
        ByteString byteString = ByteString.copyFrom(audioContents);
        // Write the response to the output file.
        try (OutputStream out = new FileOutputStream("/Users/sivanookala/IdeaProjects/output.mp3")) {
            out.write(byteString.toByteArray());
            System.out.println("Audio content written to file \"output.mp3\"");
        }catch (IOException e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
