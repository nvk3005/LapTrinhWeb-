package config;

import org.apache.catalina.*;
import org.springframework.util.ResourceUtils;

import java.net.URI;
import java.net.URL;

public class JSPStaticResourceConfigurer implements LifecycleListener {

	private final Context context;
	// trỏ tới META-INF/resources (nơi chứa JSP trong jar)
	private final String subPath = "/META-INF/resources";

	public JSPStaticResourceConfigurer(Context context) {
		this.context = context;
	}

	@Override
	public void lifecycleEvent(LifecycleEvent event) {
		// chỉ chạy khi Tomcat configure start event
		if (!Lifecycle.CONFIGURE_START_EVENT.equals(event.getType())) {
			return;
		}

		final URL finalLocation = getUrl();

		// Thêm web resource set: kiểu RESOURCE_JAR, mount root "/" tới jarLocation +
		// subPath
		this.context.getResources().createWebResourceSet(WebResourceRoot.ResourceSetType.RESOURCE_JAR, "/",
				finalLocation, subPath);
	}

	private URL getUrl() {
		final URL location = this.getClass().getProtectionDomain().getCodeSource().getLocation();

		// nếu là file URL (IDE chạy) — trả về trực tiếp
		if (ResourceUtils.isFileURL(location)) {
			return location;
		}

		// nếu chạy trong jar (jar url), chuyển dạng để Tomcat hiểu
		if (ResourceUtils.isJarURL(location)) {
			try {
				// xử lý chữ "nested:" và phần BOOT-INF/classes ... tuỳ cấu trúc fat-jar
				String locationStr = location.getPath().replaceFirst("^nested:", "")
						.replaceFirst("/!BOOT-INF/classes!/+$", "!/");

				// chuyển thành jar:file:/...!/ dạng mà tomcat mong đợi
				return new URI("jar:file", locationStr, null).toURL();
			} catch (Exception e) {
				throw new IllegalStateException("Unable to add new JSP source URI to tomcat resources", e);
			}
		}

		throw new IllegalStateException("Cannot add tomcat resources, unhandleable url: " + location);
	}
}
