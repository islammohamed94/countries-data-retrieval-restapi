package com.islam.demo.domain;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Schema(name = "Countries", description = "Data object for countries", oneOf = Countries.class)
public class Countries 
{

    @Schema(description = "Name of the Country.", example = "Bahrain", required = false)
    @Size(max = 50)
    private String name;
    
    @Schema(description = "Code of the Country.", example = "BAH", required = true)
    @Size(max = 50)
    private String country_code;
    
    @Schema(description = "Continent of the Country.", example = "Asia", required = false)
    @Size(max = 50)
    private String country_continent;
    
    @Schema(description = "Population of the Country.", example = "617000", required = false)
    @Size(max = 50)
    private long country_population;
    
    @Schema(description = "Life Expectancy of the Country.", example = "73", required = false)
    @Size(max = 50)
    private short country_life_expectancy;
    
    @Schema(description = "Language of the Country.", example = "Arabic", required = false)
    @Size(max = 50)
    private String country_language;
}
