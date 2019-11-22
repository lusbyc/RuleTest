import java.util.Map;

public interface AdFunction {
	boolean process(
      		Map<String, InputArg> inputArgs,
      		Map<String, ConstArg> constArgs,
     		Map<String, String> state);
}