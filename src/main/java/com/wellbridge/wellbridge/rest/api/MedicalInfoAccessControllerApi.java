package com.wellbridge.wellbridge.rest.api;




import com.wellbridge.wellbridge.rest.dto.requests.patient.AccessRequestDto;
import com.wellbridge.wellbridge.rest.dto.responses.patient.AccessResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface MedicalInfoAccessControllerApi {

    @PostMapping("/request")
    ResponseEntity<AccessResponseDto> requestAccess(@RequestBody AccessRequestDto requestDto);

    @PostMapping("/approve/{uuid}")
    ResponseEntity<AccessResponseDto> approveAccess(@PathVariable String uuid);

    @PostMapping("/deny/{uuid}")
    ResponseEntity<AccessResponseDto> denyAccess(@PathVariable String uuid);
}
