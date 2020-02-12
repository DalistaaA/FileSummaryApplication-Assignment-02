package com.auxenta.fileSummaryApplication;

import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	void testMain() {
		App.main(new String[]{});
		App.main(new String[]{"gffgf","fxcxb"});
		App.main(new String[]{" "});
	}

}
