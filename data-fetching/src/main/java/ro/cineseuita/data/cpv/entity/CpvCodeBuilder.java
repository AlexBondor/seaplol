package ro.cineseuita.data.cpv.entity;

public final class CpvCodeBuilder {
    private String _id;
    private String code;
    private String codeSimplified;
    private String description;
    private String parent;

    private CpvCodeBuilder() {
    }

    public static CpvCodeBuilder aCpvCode() {
        return new CpvCodeBuilder();
    }

    public CpvCodeBuilder with_id(String _id) {
        this._id = _id;
        return this;
    }

    public CpvCodeBuilder withCode(String code) {
        this.code = code;
        return this;
    }

    public CpvCodeBuilder withCodeSimplified(String codeSimplified) {
        this.codeSimplified = codeSimplified;
        return this;
    }

    public CpvCodeBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public CpvCodeBuilder withParent(String parent) {
        this.parent = parent;
        return this;
    }

    public CpvCode build() {
        CpvCode cpvCode = new CpvCode();
        cpvCode.set_id(_id);
        cpvCode.setCode(code);
        cpvCode.setCodeSimplified(codeSimplified);
        cpvCode.setDescription(description);
        cpvCode.setParent(parent);
        return cpvCode;
    }
}
