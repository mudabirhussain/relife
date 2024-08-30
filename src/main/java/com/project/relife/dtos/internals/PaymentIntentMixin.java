package com.project.relife.dtos.internals;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"lastResponse", "rawJsonObject"})
public abstract class PaymentIntentMixin {
}
