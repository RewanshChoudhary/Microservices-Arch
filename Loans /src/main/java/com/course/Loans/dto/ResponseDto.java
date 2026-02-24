package com.course.Loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Schema(name = "Response", description = "Schema to hold successful response information")
@Data
@AllArgsConstructor
public class ResponseDto<T> {

  @Schema(description = "Status code in the response")
  private String statusCode;

  @Schema(description = "Status message in the response")
  private String statusMsg;
  @Schema(description = "Can be null if not then contains data")

  private T data;

}
