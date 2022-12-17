package ir.farhad;

import javax.validation.constraints.Size;

public interface Business {

    @Size(min = 12,max = 12)
    String phone();
    String email();
}
