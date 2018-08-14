/**
 * Copyright 2017 Goncharov Stepan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.stepango.rxdatabindings

@Deprecated("Will be removed in 1.3", ReplaceWith("if (a > b) b else a"))
internal fun min(a: Short, b: Short) = if (a > b) b else a

@Deprecated("Will be removed in 1.3", ReplaceWith("if (a > b) b else a"))
internal fun min(a: Byte, b: Byte) = if (a > b) b else a

@Deprecated("Will be removed in 1.3", ReplaceWith("if (a > b) b else a"))
internal fun min(a: Char, b: Char) = if (a > b) b else a

@Deprecated("Will be removed in 1.3", ReplaceWith("if (a < b) b else a"))
internal fun max(a: Short, b: Short) = if (a < b) b else a

@Deprecated("Will be removed in 1.3", ReplaceWith("if (a < b) b else a"))
internal fun max(a: Byte, b: Byte) = if (a < b) b else a

@Deprecated("Will be removed in 1.3", ReplaceWith("if (a < b) b else a"))
internal fun max(a: Char, b: Char) = if (a < b) b else a
