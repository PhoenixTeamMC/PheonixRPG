package phoenixTeam.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Iterator;

/**
 * @author Strikingwolf
 */
public class KeysUtil {
	public static boolean allPressed(Iterable<Integer> keys) {
		for (int key : keys) {
			if (!Gdx.input.isKeyPressed(key)) {
				return false;
			}
		}
		return true;
	}
}
