package it.epicode.verificaSecurity.services.exceptionservice;

import it.epicode.verificaSecurity.dto.DtoBase;

public class PersistEntityException extends ServiceException {
    private static final long serialVersionUID = 1L;


    public final DtoBase invalidDto;

    public PersistEntityException(DtoBase invalidDto) {
        this.invalidDto = invalidDto;
    }
}
