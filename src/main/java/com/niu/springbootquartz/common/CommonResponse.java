package com.niu.springbootquartz.common;

import java.io.Serializable;
import lombok.Data;

@Data
public class CommonResponse implements Serializable {

  private static final long serialVersionUID = -8585676556295340062L;

  boolean valid;
  String msg;
  Object data;

  public CommonResponse(boolean valid, String msg) {

    super();
    this.valid = valid;
    this.msg = msg;
  }

  public CommonResponse(boolean valid) {

    super();
    this.valid = valid;
  }

  public static CommonResponse failure(String msg) {

    return new CommonResponse(false, msg);
  }

  public static CommonResponse failure(Exception e) {

    return new CommonResponse(false, e.getMessage());
  }

  public static CommonResponse failure() {

    return new CommonResponse(false);
  }

  public static CommonResponse success() {

    return new CommonResponse(true);
  }

  public static CommonResponse success(String msg) {

    return new CommonResponse(true, msg);
  }
}
