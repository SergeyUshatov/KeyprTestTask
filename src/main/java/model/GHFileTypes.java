package model;

public enum GHFileTypes{
    FILE_BLOB ("100644", "blob"),
    EXECUTABLE_BLOB ("100755", "blob"),
    SUBDIRECTORY_TREE ("040000", "tree"),
    SUBMODULE_COMMIT ("160000", "commit");

    private final String value;
    private final String type;
    GHFileTypes(String value, String type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }
}
