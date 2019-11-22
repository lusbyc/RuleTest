public class ConstArg {
	private final String name; // name of constant
	private final String value; // value converted to a string

	public ConstArg(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
