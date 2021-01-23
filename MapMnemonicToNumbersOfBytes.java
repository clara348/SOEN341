package project_B.V8;

import java.util.HashMap;
import java.util.Map;

public class MapMnemonicToNumbersOfBytes {

    public static final Map<String, Integer> map_mnemonic_to_bytes = new HashMap<>();
/*
 ldc.i3 0
 dup
 stv.u3 0 ; n = 0
 stv.u3 1 ; sum = 0
Loop ldv.u3 0 ; push n
 ldc.i8 10 ; push 10
 tlt ; if n < 10 then Continue
 brf.i5 Done ; else Done
Continue ldv.u3 1 ; push sum
 ldv.u3 0 ; push n
 add ; add n to sum
 stv.u3 1 ; store sum
 incv.u8 0 ; n++
 br.i5 Loop
Done
 halt
 */

    static {
        map_mnemonic_to_bytes.put("ldc.i3", 1);
        map_mnemonic_to_bytes.put("dup", 1);
        map_mnemonic_to_bytes.put("ldc.i8", 2);
        map_mnemonic_to_bytes.put("stv.u3", 1);
        map_mnemonic_to_bytes.put("tlt", 2);
        map_mnemonic_to_bytes.put("brf.i5", 1);
        map_mnemonic_to_bytes.put("ldv.u3", 1);
        map_mnemonic_to_bytes.put("incv.u8", 2);
        map_mnemonic_to_bytes.put("br.i5", 1);
        map_mnemonic_to_bytes.put("halt", 1);

    }
}
