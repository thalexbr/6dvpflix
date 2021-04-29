package devops.fiap.zuulserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.exception.ZuulException;

@Component
public class MyPreFilter {

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;
	public static String PRE_FILTER_TYPE;
	private static final Logger LOGGER = LoggerFactory.getLogger(MyPreFilter.class);

	@Autowired
	private FilterUtils filterUtils;

	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	public Object run() throws ZuulException {
		return null;
	}

	public String filterType() {
		return PRE_FILTER_TYPE;
	}

	public int filterOrder() {
		return FILTER_ORDER;
	}

	private boolean isCorrelationIdPresent() {
		return filterUtils.getCorrelationId() != null;
	}

	private String generateCorrelationId() {
		return java.util.UUID.randomUUID().toString();
	}
}
