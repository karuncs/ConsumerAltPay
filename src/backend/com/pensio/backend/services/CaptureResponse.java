package com.pensio.backend.services;

public class CaptureResponse {
	private boolean successful;

	public CaptureResponse(boolean successful) {
		this.successful = successful;
	}

	public boolean wasSuccessful() {
		return successful;
	}
}
