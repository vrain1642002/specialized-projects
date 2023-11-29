package com.project.shophandmade.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

//anonation
@Data//to string
@Getter
@Setter
//ham khoi dung
@AllArgsConstructor
@NoArgsConstructor
public class DanhmucsanphamDTO {
    //ID sinh o duoi co so du lieu nen k can
    @NotEmpty(message = "Khong duoc de trong ten danh muc")
    private String Ten;

}
