package eu.codeacademy.events.api.file.controller;

import eu.codeacademy.events.api.file.dto.FileResponse;
import eu.codeacademy.events.api.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Api(tags = "File Management")
public class FileController {

    private final FileService fileService;

    @ApiOperation(value = "Save image", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Image save successfully"),
            @ApiResponse(code = 401, message = "User must be authorized"),
            @ApiResponse(code = 403, message = "User is not granted to get response")
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/file/upload")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public FileResponse saveFile(@RequestParam MultipartFile file) {
       return fileService.saveFile(file);
    }

    @ApiOperation(value = "Get image by name", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Image returned successfully"),
            @ApiResponse(code = 401, message = "User must be authorized"),
            @ApiResponse(code = 403, message = "User is not granted to get response")
    })
    @GetMapping("/file/download")
    public ResponseEntity<Resource> getFileByFileName(@RequestParam String fileName) {
        return ResponseEntity.ok()
                .headers(getContentDispositionHttpHeader(fileName))
                .contentType(fileService.getFileMediaTypeByFileName(fileName))
                .body(fileService.getFile(fileName));
    }

    private HttpHeaders getContentDispositionHttpHeader(String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        return headers;
    }
}
