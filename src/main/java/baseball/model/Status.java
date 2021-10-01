package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum Status {

	STRIKE, BALL, NOTHING;

	public static List<Status> getValues() {
		List<Status> values = new ArrayList<>();
		Collections.addAll(values, Status.values());
		return values;
	}

	public static boolean isNotNothing(Status status) {
		return status != NOTHING;
	}
}
