package com.project.relife.dtos.bindings;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"lastResponse", "rawJsonObject"})
public abstract class PaymentIntentMixin {
}
