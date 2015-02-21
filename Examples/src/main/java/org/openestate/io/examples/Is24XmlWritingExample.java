/*
 * Copyright 2015 OpenEstate.org.
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

package org.openestate.io.examples;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.output.NullOutputStream;
import org.apache.commons.io.output.NullWriter;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.openestate.io.is24_xml.Is24XmlDocument;
import org.openestate.io.is24_xml.Is24XmlUtils;
import org.openestate.io.is24_xml.xml.AktionsTyp;
import org.openestate.io.is24_xml.xml.AusstattungsqualitaetsTyp;
import org.openestate.io.is24_xml.xml.BauphaseTyp;
import org.openestate.io.is24_xml.xml.EnergieausweistypTyp;
import org.openestate.io.is24_xml.xml.GenehmigungTyp;
import org.openestate.io.is24_xml.xml.HausKategorienTyp;
import org.openestate.io.is24_xml.xml.HausKauf;
import org.openestate.io.is24_xml.xml.HausMiete;
import org.openestate.io.is24_xml.xml.HeizungsartTyp;
import org.openestate.io.is24_xml.xml.ISOLaenderCodeTyp;
import org.openestate.io.is24_xml.xml.ImmobilieBaseTyp;
import org.openestate.io.is24_xml.xml.ImmobilienTransferTyp;
import org.openestate.io.is24_xml.xml.ImmobilienTransferTyp.Anbieter;
import org.openestate.io.is24_xml.xml.ObjectFactory;
import org.openestate.io.is24_xml.xml.ObjektZustandTyp;
import org.openestate.io.is24_xml.xml.StatusTyp;
import org.openestate.io.is24_xml.xml.StellplatzKategorieTyp;
import org.openestate.io.is24_xml.xml.WaehrungTyp;

/**
 * Example for XML writing.
 * <p>
 * This example illustrates the programatic creation of an ImmoXML document,
 * and how the document is written into XML.
 *
 * @author Andreas Rudolph
 */
public class Is24XmlWritingExample
{
  private final static ObjectFactory FACTORY = Is24XmlUtils.getFactory();
  private final static boolean PRETTY_PRINT = true;

  /**
   * Start the example application.
   *
   * @param args
   * command line arguments
   */
  public static void main( String[] args )
  {
    // create an ImmoXML object with some example data
    ImmobilienTransferTyp transfer = FACTORY.createImmobilienTransferTyp();
    transfer.setEmailBeiFehler( "test@test.org" );
    transfer.setErstellerSoftware( "OpenEstate.org" );
    transfer.setErstellerSoftwareVersion( "1.0" );
    transfer.setAnbieter( createAnbieter() );

    // convert ImmoXML object into a XML document
    Is24XmlDocument doc = null;
    try
    {
      doc = Is24XmlDocument.newDocument( transfer );
    }
    catch (Exception ex)
    {
      System.err.println( "Can't create XML document!" );
      ex.printStackTrace( System.err );
      System.exit( 1 );
    }

    // write XML document into a java.io.File
    try
    {
      write( doc, File.createTempFile( "is24-", ".xml" ) );
    }
    catch (IOException ex)
    {
      System.err.println( "Can't create temporary file!" );
      ex.printStackTrace( System.err );
      System.exit( 2 );
    }

    // write XML document into a java.io.OutputStream
    write( doc, new NullOutputStream() );

    // write XML document into a java.io.Writer
    write( doc, new NullWriter() );

    // write XML document into a string and send it to the console
    writeToConsole( doc );
  }

  /**
   * Create an {@link Anbieter} with some example data.
   *
   * @return
   * an example {@link Anbieter} object
   */
  protected static Anbieter createAnbieter()
  {
    // create an example agency
    Anbieter anbieter = FACTORY.createImmobilienTransferTypAnbieter();
    anbieter.setScoutKundenID( "123456" );

    // add some real estates to the agency
    anbieter.getImmobilie().add( createImmobilieHausKauf() );
    anbieter.getImmobilie().add( createImmobilieHausKauf() );
    anbieter.getImmobilie().add( createImmobilieHausMiete() );
    anbieter.getImmobilie().add( createImmobilieHausMiete() );

    return anbieter;
  }

  /**
   * Create an {@link HausKauf} with some example data.
   *
   * @return
   * an example {@link HausKauf} object
   */
  protected static HausKauf createImmobilieHausKauf()
  {
    // create an example real estate
    HausKauf.Type obj = FACTORY.createHausKaufType();
    initImmobilie( obj );

    obj.setAlsFerienwohnungGeeignet( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setAnzahlBadezimmer( RandomUtils.nextLong( 1, 5 ) );
    obj.setAnzahlGaragenStellplaetze( RandomUtils.nextLong( 0, 3 ) );
    obj.setAnzahlSchlafzimmer( RandomUtils.nextLong( 1, 5 ) );
    obj.setAusstattungsqualitaet( AusstattungsqualitaetsTyp.LUXUS );
    obj.setBarrierefrei( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setBaujahr( RandomUtils.nextLong( 1900, 2010 ) );
    obj.setBauphase( BauphaseTyp.HAUS_FERTIG_GESTELLT );
    obj.setDenkmalschutzobjekt( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setEtagenzahl( RandomUtils.nextLong( 1, 10 ) );
    obj.setFreiAb( "notes about availability" );
    obj.setGaesteWC( RandomUtils.nextInt( 0, 2 )==1);
    obj.setGrundstuecksFlaeche( RandomUtils.nextDouble( 100, 1500 ) );
    obj.setHausKategorie( HausKategorienTyp.MEHRFAMILIENHAUS );
    obj.setHeizungsart( HeizungsartTyp.ETAGENHEIZUNG );
    obj.setJahrLetzteModernisierung( RandomUtils.nextLong( 1980, 2000 ) );
    obj.setKeller( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setMitEinliegerwohnung( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setNutzflaeche( RandomUtils.nextDouble( 100, 1000 ) );
    obj.setObjektzustand( ObjektZustandTyp.NEUWERTIG );
    obj.setParkplatz( StellplatzKategorieTyp.TIEFGARAGE );
    obj.setRollstuhlgerecht( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setVermietet( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setWohnflaeche( RandomUtils.nextDouble( 50, 500 ) );
    obj.setZimmer( RandomUtils.nextDouble( 1, 10 ) );

    obj.setBefeuerungsArt( FACTORY.createBefeuerungsArtTyp() );
    obj.getBefeuerungsArt().setOel( FACTORY.createBefeuerungsArtTypOel( Boolean.TRUE ) );
    obj.getBefeuerungsArt().setGas( FACTORY.createBefeuerungsArtTypGas( Boolean.TRUE ) );

    obj.setEnergieausweis( FACTORY.createEnergieausweisTyp() );
    obj.getEnergieausweis().setEnergieausweistyp( EnergieausweistypTyp.ENERGIEVERBRAUCHSKENNWERT );
    obj.getEnergieausweis().setEnergieverbrauchskennwert( RandomUtils.nextDouble( 50, 500 ) );
    obj.getEnergieausweis().setWarmwasserEnthalten( RandomUtils.nextInt( 0, 2 )==1 );

    obj.setKaufpreise( FACTORY.createVermarktungWohnKaufTyp() );
    obj.getKaufpreise().setKaufpreis( RandomUtils.nextDouble( 100000, 9999999 ) );
    obj.getKaufpreise().setMieteinnahmenProMonat( RandomUtils.nextDouble( 5000, 50000 ) );
    obj.getKaufpreise().setStellplatzKaufpreis( RandomUtils.nextDouble( 1000, 10000 ) );
    obj.getKaufpreise().setWohngeld( RandomUtils.nextDouble( 500, 5000 ) );

    return FACTORY.createHausKauf( obj );
  }

  /**
   * Create an {@link HausMiete} with some example data.
   *
   * @return
   * an example {@link HausMiete} object
   */
  protected static HausMiete createImmobilieHausMiete()
  {
    // create an example real estate
    HausMiete.Type obj = FACTORY.createHausMieteType();
    initImmobilie( obj );

    obj.setAnzahlBadezimmer( RandomUtils.nextLong( 1, 5 ) );
    obj.setAnzahlGaragenStellplaetze( RandomUtils.nextLong( 0, 3 ) );
    obj.setAnzahlSchlafzimmer( RandomUtils.nextLong( 1, 5 ) );
    obj.setAusstattungsqualitaet( AusstattungsqualitaetsTyp.GEHOBEN );
    obj.setBarrierefrei( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setBaujahr( RandomUtils.nextLong( 1900, 2010 ) );
    obj.setBetreutesWohnen( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setEinbaukueche( RandomUtils.nextInt( 0, 2 )==1);
    obj.setEtagenzahl( RandomUtils.nextLong( 1, 10 ) );
    obj.setFreiAb( "notes about availability" );
    obj.setGaesteWC( RandomUtils.nextInt( 0, 2 )==1);
    obj.setGrundstuecksFlaeche( RandomUtils.nextDouble( 100, 1500 ) );
    obj.setHausKategorie( HausKategorienTyp.EINFAMILIENHAUS );
    obj.setHaustiere( GenehmigungTyp.NACH_VEREINBARUNG );
    obj.setHeizungsart( HeizungsartTyp.ZENTRALHEIZUNG );
    obj.setJahrLetzteModernisierung( RandomUtils.nextLong( 1980, 2000 ) );
    obj.setKeller( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setNutzflaeche( RandomUtils.nextDouble( 150, 500 ) );
    obj.setObjektzustand( ObjektZustandTyp.GEPFLEGT );
    obj.setParkplatz( StellplatzKategorieTyp.CARPORT );
    obj.setRollstuhlgerecht( RandomUtils.nextInt( 0, 2 )==1 );
    obj.setWohnflaeche( RandomUtils.nextDouble( 50, 300 ) );
    obj.setZimmer( RandomUtils.nextDouble( 1, 5 ) );

    obj.setBefeuerungsArt( FACTORY.createBefeuerungsArtTyp() );
    obj.getBefeuerungsArt().setErdwaerme( FACTORY.createBefeuerungsArtTypErdwaerme( Boolean.TRUE ) );
    obj.getBefeuerungsArt().setPelletheizung( FACTORY.createBefeuerungsArtTypPelletheizung( Boolean.TRUE ) );

    obj.setEnergieausweis( FACTORY.createEnergieausweisTyp() );
    obj.getEnergieausweis().setEnergieausweistyp( EnergieausweistypTyp.ENERGIEVERBRAUCHSKENNWERT );
    obj.getEnergieausweis().setEnergieverbrauchskennwert( RandomUtils.nextDouble( 50, 500 ) );
    obj.getEnergieausweis().setWarmwasserEnthalten( RandomUtils.nextInt( 0, 2 )==1 );

    obj.setMietpreise( FACTORY.createVermarktungWohnMieteTyp() );
    obj.getMietpreise().setHeizkosten( RandomUtils.nextDouble( 100, 500 ) );
    obj.getMietpreise().setHeizkostenInWarmmieteEnthalten( RandomUtils.nextInt( 0, 2 )==1 );
    obj.getMietpreise().setKaltmiete( RandomUtils.nextDouble( 150, 1500 ) );
    obj.getMietpreise().setKaution( "notes about deposit" );
    obj.getMietpreise().setNebenkosten( RandomUtils.nextDouble( 50, 500 ) );
    obj.getMietpreise().setStellplatzMiete( RandomUtils.nextDouble( 50, 500 ) );
    obj.getMietpreise().setWarmmiete( RandomUtils.nextDouble( 250, 2500 ) );

    return FACTORY.createHausMiete( obj );
  }

  protected static void initImmobilie( ImmobilieBaseTyp immobilie )
  {
    immobilie.setAdressdruck( RandomUtils.nextInt( 0, 2 )==1 );
    immobilie.setAktiveGruppen( "active groups" );
    immobilie.setAnbieterObjektID( "123" );
    immobilie.setAusstattung( "notes about features" );
    immobilie.setGruppierungsID( RandomUtils.nextLong( 1, 9999 ) );
    immobilie.setImportmodus( AktionsTyp.AKTUALISIEREN );
    immobilie.setLage( "notes about location" );
    immobilie.setObjektbeschreibung( "notes about the property" );
    immobilie.setProvision( "commission" );
    immobilie.setProvisionshinweis( "notes about commission" );
    immobilie.setProvisionspflichtig( RandomUtils.nextInt( 0, 2 )==1 );
    immobilie.setScoutObjektID( 456L );
    immobilie.setSonstigeAngaben( "further notes" );
    immobilie.setStatusHP( StatusTyp.AKTIV );
    immobilie.setStatusIS24( StatusTyp.AKTIV );
    immobilie.setStatusVBM( StatusTyp.INAKTIV );
    immobilie.setUeberschrift( "title of the property" );
    immobilie.setWaehrung( WaehrungTyp.EUR );

    immobilie.setAdresse( FACTORY.createImmobilienAdresseTyp() );
    immobilie.getAdresse().setHausnummer( "1" );
    immobilie.getAdresse().setInternationaleRegion( "Berlin" );
    immobilie.getAdresse().setLaenderkennzeichen( ISOLaenderCodeTyp.DEU );
    immobilie.getAdresse().setOrt( "Berlin" );
    immobilie.getAdresse().setPostleitzahl( "12345" );
    immobilie.getAdresse().setStrasse( "name of the street" );

    immobilie.setApiSuchfelder( FACTORY.createImmobilieBaseTypApiSuchfelder( FACTORY.createApiSuchfelderTyp() ) );
    immobilie.getApiSuchfelder().getValue().setApiSuchfeld1( FACTORY.createApiSuchfelderTypApiSuchfeld1( "value1" ) );
    immobilie.getApiSuchfelder().getValue().setApiSuchfeld2( FACTORY.createApiSuchfelderTypApiSuchfeld2( "value2" ) );
    immobilie.getApiSuchfelder().getValue().setApiSuchfeld3( FACTORY.createApiSuchfelderTypApiSuchfeld3( "value3" ) );

    immobilie.setKontaktperson( FACTORY.createKontaktAdresseTyp() );
    immobilie.getKontaktperson().setAnrede( "addressing" );
    immobilie.getKontaktperson().setEMail( "tester@test.org" );
    immobilie.getKontaktperson().setHausnummer( "1" );
    immobilie.getKontaktperson().setLaenderkennzeichen( ISOLaenderCodeTyp.DEU );
    immobilie.getKontaktperson().setMobiltelefon( "030/123456" );
    immobilie.getKontaktperson().setNachname( "Mustermann" );
    immobilie.getKontaktperson().setOrt( "Berlin" );
    immobilie.getKontaktperson().setPostleitzahl( "13125" );
    immobilie.getKontaktperson().setStrasse( "name of the street" );
    immobilie.getKontaktperson().setTelefax( "030/123457" );
    immobilie.getKontaktperson().setTelefon( "030/123458" );
    immobilie.getKontaktperson().setVorname( "Max" );
    try
    {
      immobilie.getKontaktperson().setHomepage( new URL( "http://mywebsite.com" ) );
    }
    catch (MalformedURLException ex)
    {}

    immobilie.setManuelleGeoCodierung( FACTORY.createManuellGeoCodingTyp() );
    immobilie.getManuelleGeoCodierung().setTermsRegion( "name of region" );
    immobilie.getManuelleGeoCodierung().setTermsStadt( "name of city" );
    immobilie.getManuelleGeoCodierung().setTermsStadtTeil( "name of district" );
  }

  /**
   * Write a {@link Is24XmlDocument} into a {@link File}.
   *
   * @param doc
   * the document to write
   *
   * @param file
   * the file, where the document is written to
   */
  protected static void write( Is24XmlDocument doc, File file )
  {
    System.out.println( "writing document" );
    try
    {
      doc.toXml( file, PRETTY_PRINT );
      System.out.println( "> written to: " + file.getAbsolutePath() );
    }
    catch (Exception ex)
    {
      System.err.println( "Can't write document into a file!" );
      ex.printStackTrace( System.err );
      System.exit( 2 );
    }
  }

  /**
   * Write a {@link Is24XmlDocument} into an {@link OutputStream}.
   *
   * @param doc
   * the document to write
   *
   * @param output
   * the stream, where the document is written to
   */
  protected static void write( Is24XmlDocument doc, OutputStream output )
  {
    System.out.println( "writing document" );
    try
    {
      doc.toXml( output, PRETTY_PRINT );
      System.out.println( "> written to a java.io.OutputStream" );
    }
    catch (Exception ex)
    {
      System.err.println( "Can't write document into an OutputStream!" );
      ex.printStackTrace( System.err );
      System.exit( 2 );
    }
  }

  /**
   * Write a {@link Is24XmlDocument} into an {@link Writer}.
   *
   * @param doc
   * the document to write
   *
   * @param output
   * the writer, where the document is written to
   */
  protected static void write( Is24XmlDocument doc, Writer output )
  {
    System.out.println( "writing document" );
    try
    {
      doc.toXml( output, PRETTY_PRINT );
      System.out.println( "> written to a java.io.Writer" );
    }
    catch (Exception ex)
    {
      System.err.println( "Can't write document into an OutputStream!" );
      ex.printStackTrace( System.err );
      System.exit( 2 );
    }
  }

  /**
   * Write a {@link Is24XmlDocument} into a {@link String} and print the
   * results to the console.
   *
   * @param doc
   * the document to write
   */
  protected static void writeToConsole( Is24XmlDocument doc )
  {
    System.out.println( "writing document" );
    try
    {
      String xml = doc.toXmlString( PRETTY_PRINT );
      System.out.println( StringUtils.repeat( "-", 50 ) );
      System.out.println( xml );
      System.out.println( StringUtils.repeat( "-", 50 ) );
    }
    catch (Exception ex)
    {
      System.err.println( "Can't write document into a string!" );
      ex.printStackTrace( System.err );
      System.exit( 2 );
    }
  }
}