package hu.reverselogic.meter_reading.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.reverselogic.meter_reading.repositories.ImageRepository;

@Controller
public class ImageController
{
    @Autowired
    ImageRepository imageRepository;

    @GetMapping(value = "/image/{imagename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable String imagename) throws IOException {
        
        return imageRepository.findByName(imagename).getData();
    }
}
