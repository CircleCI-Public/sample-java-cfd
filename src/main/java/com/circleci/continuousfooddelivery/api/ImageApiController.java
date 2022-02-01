package com.circleci.continuousfooddelivery.api;

import com.circleci.continuousfooddelivery.jpa.ImageJpa;
import com.circleci.continuousfooddelivery.model.InlineResponse200;
import com.circleci.continuousfooddelivery.repositories.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-01-31T03:17:46.722516300-05:00[America/New_York]")
@RestController
@RequestMapping("${openapi.continousFoodDelievery.base-path:/CFD/1.0.0}")
public class ImageApiController implements ImageApi {

    @Autowired
    private ImageRepo repository;

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ImageApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<InlineResponse200> addImage(MultipartFile file) {
        try {
            ImageJpa jpa = repository.save(new ImageJpa(file.getContentType(), file.getBytes()));

            return ResponseEntity.ok(new InlineResponse200().imageId(jpa.getId()));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Void> deleteImage(Integer imageId) {
        if (repository.existsById(imageId)) {
            repository.deleteById(imageId);

            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Resource> getImage(Integer imageId) {
        ImageJpa image = repository.findById(imageId).get();
        ByteArrayResource resource = new ByteArrayResource(image.getData());

        if (repository.existsById(imageId)) {
            return ResponseEntity.ok().contentLength(resource.contentLength()).
                    contentType(MediaType.parseMediaType(image.getContentType())).body(resource);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
