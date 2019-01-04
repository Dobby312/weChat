package material;

import org.junit.Test;



public class DoUpload {
	@Test
	public void doUpload() {
		String file = "F:\\3.jpg";
		String result = Upload.upload(file, "image");
	}
}
