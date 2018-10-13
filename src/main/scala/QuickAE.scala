
import java.io.FileOutputStream

import org.apache.ctakes.core.cr.TextReader
import org.apache.ctakes.typesystem.`type`.textsem.DiseaseDisorderMention
import org.apache.uima.analysis_engine.AnalysisEngine
import org.apache.uima.cas.AbstractCas
import org.apache.uima.fit.factory.{AnalysisEngineFactory, CollectionReaderFactory, JCasFactory}
import org.apache.uima.fit.pipeline.SimplePipeline
import org.apache.uima.fit.util.JCasUtil
import org.apache.uima.jcas.JCas
import org.apache.uima.jcas.tcas.Annotation
import org.hsqldb.jdbc.JDBCCallableStatement


class QuickAE extends org.apache.uima.fit.component.JCasAnnotator_ImplBase{
  override def process(aJCAS:JCas): Unit = {
    println(">>>> i'am working")
    val all = JCasUtil.selectAll(aJCAS)
    println("all.size(): " + all.size())
    val diseaseOrDisorders = JCasUtil.select(aJCAS, classOf[DiseaseDisorderMention])
    for(d <- diseaseOrDisorders.toArray){
      println(">>> Found: "+d)
    }
    println("disease or disorder "+diseaseOrDisorders)
    //    val rawText = aJCAS.getDocumentText
    //    println(">>>>>> raw text: "+rawText)
    //    val regex = "[A-Z]+".r
    //    val matches = regex.findAllMatchIn(rawText)
    //    println("matches:")
    //    for (m <-matches){
    //      println("> "+m)
    //      val annotation = new Annotation(aJCAS)
    //      annotation.setBegin(m.start)
    //      annotation.setEnd(m.end)
    //      annotation.addToIndexes()
    //      println("annotation added: " + annotation)
    //    }
  }

}
