
public class PGMR_LVL3_LongJump {

}
class PGMR_LVL3_LongJump_Solution {
	public long solution(int n) {
		long answer = 0;
		long [] cache = new long[2001];
		cache[0] = 1;
		cache[1] = 1;
		for(int i=2; i<=n; i++) {
			cache[i] = cache[i-2] + cache[i-1];
            cache[i] = cache[i]%1234567;
		}
		return cache[n];
	}
}