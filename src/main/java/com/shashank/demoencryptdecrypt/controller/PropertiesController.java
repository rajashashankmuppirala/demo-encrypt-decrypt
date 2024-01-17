package com.shashank.demoencryptdecrypt.controller;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Value("${myEncryptedKey:default}")
    private String myEncryptedKey;

    @Value("${myJasyptEncryptedKey:default}")
    private String myJasyptEncryptedKey;

    @GetMapping(value = "/key")
    private ResponseEntity<String> getDecryptedKey(){
       return ResponseEntity.ok(myEncryptedKey);
    }

    @GetMapping(value = "/jasypt-key")
    private ResponseEntity<String> getJasyptDecryptedKey(){
        return ResponseEntity.ok(myJasyptEncryptedKey);
    }
}
