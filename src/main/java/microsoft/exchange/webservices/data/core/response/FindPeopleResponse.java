/*
 * The MIT License
 * Copyright (c) 2012 Microsoft Corporation
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package microsoft.exchange.webservices.data.core.response;

import java.util.ArrayList;
import java.util.List;

import microsoft.exchange.webservices.data.core.EwsServiceXmlReader;
import microsoft.exchange.webservices.data.core.EwsUtilities;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.XmlElementNames;
import microsoft.exchange.webservices.data.core.enumeration.misc.XmlNamespace;
import microsoft.exchange.webservices.data.core.enumeration.misc.error.ServiceError;
import microsoft.exchange.webservices.data.core.exception.service.remote.ServiceResponseException;
import microsoft.exchange.webservices.data.misc.NameResolutionCollection;
import microsoft.exchange.webservices.data.property.complex.EmailAddress;
import microsoft.exchange.webservices.data.property.complex.EmailAddressCollection;
import microsoft.exchange.webservices.data.property.complex.Persona;
import microsoft.exchange.webservices.data.property.complex.Rule;

/**
 * Represents the response to a name resolution operation.
 */
public final class FindPeopleResponse extends ServiceResponse {

  /**
   * The people lists.
   */
  private List<Persona> personaList = new ArrayList<Persona>();

  /**
   * Represents the response to a FindPeopleResponse operation.
   */
  public FindPeopleResponse() {
    super();
  }

  /**
   * Gets all persona list returned.
   *
   * @return the persona lists
   */
  public List<Persona> getPersonaList() {
    return this.personaList;
  }

  /**
   * Reads response elements from XML.
   *
   * @param reader the reader
   * @throws Exception the exception
   */
  @Override
  protected void readElementsFromXml(EwsServiceXmlReader reader)
          throws Exception {
    this.personaList.clear();
    super.readElementsFromXml(reader);

    reader.readStartElement(XmlNamespace.Messages, XmlElementNames.People);

    if (!reader.isEmptyElement()) {
      // Because we don't have an element for count of returned object,
      // we have to test the element to determine if it is return object
      // or EndElement
      reader.read();

      while (reader.isStartElement(XmlNamespace.Types, XmlElementNames.Persona)) {
        Persona persona = new Persona();
        persona.loadFromXml(reader, XmlElementNames.Persona);
        this.personaList.add(persona);
        reader.read();
      }

      if (reader.isStartElement(XmlNamespace.Messages, XmlElementNames.TotalNumberOfPeopleInView)
              && !reader.isEmptyElement()) {
        reader.read();
      }

      if (reader.isStartElement(XmlNamespace.Messages, XmlElementNames.FirstMatchingRowIndex)
              && !reader.isEmptyElement()) {
        reader.read();
      }


      if (reader.isStartElement(XmlNamespace.Messages, XmlElementNames.FirstLoadedRowIndex)
              && !reader.isEmptyElement()) {
        reader.read();
      }

      if (reader.isStartElement(XmlNamespace.Messages, XmlElementNames.FindPeopleTransactionId)
              && !reader.isEmptyElement()) {
        reader.read();
      }

      // Future proof by skipping any additional elements before returning
      while (!reader.isEndElement(XmlNamespace.Messages, XmlElementNames.FindPeopleResponse)) {
        reader.read();
      }
    } else {
      reader.read();
    }
    return;
  }

}