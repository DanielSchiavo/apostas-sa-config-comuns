package com.apostassa.aplicacao;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.UUID;

@Mapper(builder = @Builder(disableBuilder = true), unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConversoresComunsMapper {

    @Named(value = "converterStringEmUUID")
    default UUID converterStringEmUUID(String value) {
        return UUID.fromString(value);
    }
}
