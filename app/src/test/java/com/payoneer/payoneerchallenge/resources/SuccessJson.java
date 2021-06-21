package com.payoneer.payoneerchallenge.resources;

public class SuccessJson {

    public static final String SUCCESS_JSON =
            "{\n" +
                    "  \"networks\": {\n" +
                    "    \"applicable\": [\n" +
                    "      {\n" +
                    "        \"code\": \"AMEX\",\n" +
                    "        \"label\": \"American Express\",\n" +
                    "        \"method\": \"CREDIT_CARD\",\n" +
                    "        \"grouping\": \"CREDIT_CARD\",\n" +
                    "        \"registration\": \"OPTIONAL\",\n" +
                    "        \"recurrence\": \"NONE\",\n" +
                    "        \"redirect\": false,\n" +
                    "        \"links\": {\n" +
                    "          \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/amex.png\",\n" +
                    "          \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/AMEX\",\n" +
                    "          \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/AMEX.json\",\n" +
                    "          \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/AMEX/charge\",\n" +
                    "          \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/AMEX/standard/validate\"\n" +
                    "        },\n" +
                    "        \"selected\": false,\n" +
                    "        \"inputElements\": [\n" +
                    "          {\n" +
                    "            \"name\": \"number\",\n" +
                    "            \"type\": \"numeric\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"expiryMonth\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"expiryYear\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"verificationCode\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"holderName\",\n" +
                    "            \"type\": \"string\"\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"operationType\": \"CHARGE\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"code\": \"DINERS\",\n" +
                    "        \"label\": \"Diners Club\",\n" +
                    "        \"method\": \"CREDIT_CARD\",\n" +
                    "        \"grouping\": \"CREDIT_CARD\",\n" +
                    "        \"registration\": \"OPTIONAL\",\n" +
                    "        \"recurrence\": \"NONE\",\n" +
                    "        \"redirect\": false,\n" +
                    "        \"links\": {\n" +
                    "          \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/diners.png\",\n" +
                    "          \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/DINERS\",\n" +
                    "          \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/DINERS.json\",\n" +
                    "          \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/DINERS/charge\",\n" +
                    "          \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/DINERS/standard/validate\"\n" +
                    "        },\n" +
                    "        \"selected\": false,\n" +
                    "        \"inputElements\": [\n" +
                    "          {\n" +
                    "            \"name\": \"number\",\n" +
                    "            \"type\": \"numeric\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"expiryMonth\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"expiryYear\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"verificationCode\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"holderName\",\n" +
                    "            \"type\": \"string\"\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"operationType\": \"CHARGE\"\n" +
                    "      },\n" +
                    "      {\n" +
                    "        \"code\": \"DISCOVER\",\n" +
                    "        \"label\": \"Discover\",\n" +
                    "        \"method\": \"CREDIT_CARD\",\n" +
                    "        \"grouping\": \"CREDIT_CARD\",\n" +
                    "        \"registration\": \"OPTIONAL\",\n" +
                    "        \"recurrence\": \"NONE\",\n" +
                    "        \"redirect\": false,\n" +
                    "        \"links\": {\n" +
                    "          \"logo\": \"https://raw.githubusercontent.com/optile/checkout-android/develop/checkout/src/main/assets/networklogos/discover.png\",\n" +
                    "          \"self\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/DISCOVER\",\n" +
                    "          \"lang\": \"https://resources.integration.oscato.com/resource/lang/MOBILETEAM/en_US/DISCOVER.json\",\n" +
                    "          \"operation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/DISCOVER/charge\",\n" +
                    "          \"validation\": \"https://api.integration.oscato.com/pci/v1/6076b2feabe8170009d56de4l7ab1tlvai852jekk4s2h2b7it/MOBILETEAM/en_US/DISCOVER/standard/validate\"\n" +
                    "        },\n" +
                    "        \"selected\": false,\n" +
                    "        \"inputElements\": [\n" +
                    "          {\n" +
                    "            \"name\": \"number\",\n" +
                    "            \"type\": \"numeric\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"expiryMonth\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"expiryYear\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"verificationCode\",\n" +
                    "            \"type\": \"integer\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"name\": \"holderName\",\n" +
                    "            \"type\": \"string\"\n" +
                    "          }\n" +
                    "        ],\n" +
                    "        \"operationType\": \"CHARGE\"\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  }\n" +
                    "}";
}
