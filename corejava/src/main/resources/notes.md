Learn about: 

    YAML   -> Snake Yaml
    CSV    -> Open CSV
    Excel  -> Apache POI
    PDF    -> Apache FOP

JSON Annotation:

    @JsonInclude(Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("name")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")

Jackson ObjectMapper:
    
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(object);
        mapper.readValue(json, Object.class);

Custom Serializer:
    
    public class CustomSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString("Custom Serializer");
        }
    }

Custom Deserializer:

    public class CustomDeserializer extends JsonDeserializer<Object> {
        @Override
        public Object deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return "Custom Deserializer";
        }
    }

Json Polymorphic Deserialization:

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    public class Animal {
        private String name;
    }

    public class Dog extends Animal {
        private String breed;
    }

    public class Cat extends Animal {
        private int age;
    }

Json Polymorphic Serialization:

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Cat.class, name = "cat")
    })
    public class Animal {
        private String name;
    }

    public class Dog extends Animal {
        private String breed;
    }

    public class Cat extends Animal {
        private int age;
    }

    ObjectMapper mapper = new ObjectMapper();
    mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
    mapper.writeValueAsString(new Dog());