package com.islam.demo.web;
import com.islam.demo.domain.Countries;
import com.islam.demo.domain.CountriesRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Countries", description = "the Countries API")
public class CountriesRestController 
{
    private final CountriesRepository repository=null;
    @Operation(summary = "Find Country by code", description = "Get country by code.", tags = {"Countries"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESSFULL_OPERATION",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Countries.class)))),
            @ApiResponse(responseCode = "500", description = "INTERNAL_ERROR"),
            @ApiResponse(responseCode = "400", description = "INVALID_COUNTRY_CODE")})
    @GetMapping(value = "/Countries", params = {"country_code"})
    @ResponseStatus(HttpStatus.OK)
    
    public Collection<Countries> findCountryByCode(
            @Parameter(description = "country_code", required = true)
            @RequestParam(value = "country_code") String cntrycode)
    {
        Collection<Countries> collection = repository.findAll(cntrycode);
        return collection;
    }
}
