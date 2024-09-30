package io.bayrktlihn.javasoaptutorial.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CountryResponse {
    private String name;
    private String capital;
    private String phoneCode;


}
