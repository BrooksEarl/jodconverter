/*
 * Copyright 2004 - 2012 Mirko Nasato and contributors
 *           2016 - 2019 Simon Braconnier and contributors
 *
 * This file is part of JODConverter - Java OpenDocument Converter.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jodconverter.job;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

import org.jodconverter.document.DocumentFormat;

/** A conversion job with a specified source for the conversion. */
public interface ConversionJobWithSourceSpecified {

  /**
   * Configures the current conversion to write the result to the specified target.
   *
   * @param target The file to which the result of the conversion will be written. Existing files
   *     will be overwritten. If the file is locked by the JVM or any other application or is not
   *     writable, an exception will be thrown.
   * @return The current conversion specification.
   */
  ConversionJobWithOptionalTargetFormatUnspecified to(File target);

  /**
   * Configures the current conversion to write the result to the specified {@link OutputStream}.
   * The stream will be closed after the conversion is written.
   *
   * @param target The output stream to which the conversion result is written to.
   * @return The current conversion specification.
   */
  ConversionJobWithRequiredTargetFormatUnspecified to(OutputStream target);

  /**
   * Configures the current conversion to write the result to the specified {@link OutputStream}.
   * The stream will be closed after the conversion is written.
   *
   * @param target The output stream to which the conversion result is written to.
   * @param closeStream Determines whether the output stream is closed after writing the result.
   * @return The current conversion specification.
   */
  ConversionJobWithRequiredTargetFormatUnspecified to(OutputStream target, boolean closeStream);

  /**
   * Adds source to list of files to merge, document type is recognized ty extension
   *
   * @param source Merging input as {@link File}
   * @return The current conversion specification
   */
  ConversionJobWithSourceSpecified append(File source);

  /**
   * Adds source to list of files to merge, because this method not recognize document type {@code
   * documentFormat} must be not null
   *
   * @param source Merging input as {@link File}
   * @param documentFormat type of document
   * @return The current conversion specification
   */
  ConversionJobWithSourceSpecified append(File source, DocumentFormat documentFormat);

  /**
   * Adds source to list of files to merge from {@link InputStream}, because method is not able to
   * recognize type {@code documentType} must be not null
   *
   * @param source Merging input as {@link InputStream}
   * @param documentFormat type of document
   * @return The current conversion specification
   */
  ConversionJobWithSourceSpecified append(InputStream source, DocumentFormat documentFormat);

  /**
   * Adds source to list of files to merge from {@link InputStream}, because method is not able to
   * recognize type {@code documentType} must be not null
   *
   * @param source Merging input as {@link InputStream}
   * @param documentFormat type of document
   * @param closeStream whether the stream should be closed
   * @return The current conversion specification
   */
  ConversionJobWithSourceSpecified append(
      InputStream source, DocumentFormat documentFormat, boolean closeStream);
}
