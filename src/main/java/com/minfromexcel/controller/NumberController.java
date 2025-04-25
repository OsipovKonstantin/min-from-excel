package com.minfromexcel.controller;

import com.minfromexcel.service.NumberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NumberController {
    private final NumberService numberService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Получить N-е минимальное число из таблицы .xlsx")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Успешный запрос",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "integer", example = "2"))),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "object",
                                    example = "{\"httpStatus\": \"BAD_REQUEST\", \"message\": " +
                                            "\"Failed to convert value of type 'java.lang.String' to required type " +
                                            "'int'; For input string: \\\"3d\\\"\"}"))),
            @ApiResponse(responseCode = "404", description = "Файл не найден",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "object",
                                    example = "{\"httpStatus\": \"NOT_FOUND\", \"message\": " +
                                            "\"C:\\\\Users\\\\Константин\\\\Downloads\\\\example.xlsx (Не удается " +
                                            "найти указанный файл)\"}"))),
            @ApiResponse(responseCode = "422", description = "Недостаточно уникальных чисел в файле",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "object",
                                    example = "{\"httpStatus\": \"UNPROCESSABLE_ENTITY\", \"message\": \"Недостаточно" +
                                            " уникальных чисел в файле.\"}"))),
            @ApiResponse(responseCode = "500", description = "Ошибка на сервере",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(type = "object",
                                    example = "{\"httpStatus\": \"INTERNAL_SERVER_ERROR\", \"message\": \"Недостаточно" +
                                            " уникальных чисел в файле.\"}")))
    })
    public Integer getNthMin(@RequestParam String filePath, @RequestParam int n) throws IOException {
        return numberService.getNthMin(filePath, n);
    }
}
