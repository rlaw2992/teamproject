package dip.clever.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CleverErrorController implements ErrorController {
	public String getErrorPath() {
		return null;
	}

	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

		if (status != null) {
			int statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.FORBIDDEN.value()) {
				return "error/403";
			} else if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error/404";
			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error/500";
			} else {
				return "error/error";
			}
		}
		return "error/error";
	}

	@GetMapping("/403")
	public String FORBIDDEN() {
		return "error/403";
	}

	@GetMapping("/404")
	public String NOT_FOUND() {
		return "error/404";
	}

	@GetMapping("/500")
	public String INTERNAL_SERVER_ERROR() {
		return "error/500";
	}

	@GetMapping("/defaultError")
	public String DEFAULT_ERROR() {
		return "error/error";
	}
}
