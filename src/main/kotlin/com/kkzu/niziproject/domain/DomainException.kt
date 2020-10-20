package com.kkzu.niziproject.domain

import java.lang.RuntimeException

class DomainException(message: String): RuntimeException(message)