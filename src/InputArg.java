public class InputArg {
	
	private final long ts; // time stamp (epoch)
	private final String name; // name of the input value
	private final String value; // value converted to a string

	public InputArg(long ts, String name, String value) {
		this.ts = ts;
		this.name = name;
		this.value = value;
	}

	public long getTs() {
		return ts;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
