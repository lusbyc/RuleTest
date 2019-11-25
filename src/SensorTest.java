import java.util.Map;

public class SensorTest implements AdFunction {

	@Override
	public boolean process(Map<String, InputArg> inputArgs, Map<String, ConstArg> constArgs,
			Map<String, String> state) {

		Double currentTemp = (Double.parseDouble(inputArgs.get("ZoneTemp").getValue()));

		long time = inputArgs.get("ZoneTemp").getTs();
		long twentyMinPast = time - 20 * 60 * 1000;

		Double temp20MinAgo = Double.parseDouble(state.get(String.valueOf(twentyMinPast)));

		Double highBandValue = Double.parseDouble(constArgs.get("HighBand").getValue());
		Double lowBandValue = Double.parseDouble(constArgs.get("LowBand").getValue());

		boolean fanIsOn = inputArgs.get("FanSts").getValue().equalsIgnoreCase("true")
				|| inputArgs.get("FanSts").getValue().equalsIgnoreCase("1");

		boolean tempTooHigh = currentTemp > highBandValue;
		boolean tempTooLow = currentTemp < lowBandValue;

		Double minVarianceValue = currentTemp * -1.01;
		Double maxVarianceValue = currentTemp * 1.01;

		boolean tempHasNotVaried = temp20MinAgo >= minVarianceValue && temp20MinAgo <= maxVarianceValue;

//		Condition 1
		if (fanIsOn && (tempTooHigh || tempTooLow)) {
			return true;
//		Condition 2
		} else if (fanIsOn && tempHasNotVaried) {
			return true;
		} else {
			return false;
		}
	}
}