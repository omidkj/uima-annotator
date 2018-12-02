

import org.apache.ctakes.core.sentence.SentenceDetectorCtakes
import org.apache.ctakes.typesystem.`type`.textsem.{DiseaseDisorderMention, EntityMention, IdentifiedAnnotation, SignSymptomMention}
import org.apache.ctakes.typesystem.`type`.refsem.{OntologyConcept, UmlsConcept}
import org.apache.uima.cas.text.AnnotationFS
import org.apache.uima.fit.`type`.Sentence
import org.apache.uima.jcas.JCas
import org.apache.uima.fit.util.JCasUtil
import org.apache.uima.jcas.tcas.Annotation
import org.apache.uima.cas

import scala.collection.JavaConverters._


class QuickAE extends org.apache.uima.fit.component.JCasAnnotator_ImplBase{
  override def process(aJCAS:JCas): Unit = {
    println(">>>> i'am working")
    val all = JCasUtil.selectAll(aJCAS)
    println("all.size(): " + all.size())
    val diseaseOrDisorders = JCasUtil.select(aJCAS, classOf[DiseaseDisorderMention])
    println(">>> something:  : "+ diseaseOrDisorders.getClass)
    val diseaseOrDisorders_array = diseaseOrDisorders.toArray(new Array[DiseaseDisorderMention](0))
    println(">>> something-----:  : "+ diseaseOrDisorders_array.getClass)

    for(d <- diseaseOrDisorders_array) {
      var umlsconcept = JCasUtil.select(d.getOntologyConceptArr(), classOf[UmlsConcept])
      var umlsconcept_array = umlsconcept.toArray(new Array[UmlsConcept](0))

      var positive_case = false
      for (con <- umlsconcept_array) {
        if (con.getCui == "C0034065") {
          println(">>>>>>>  printing cui:  " + con.getCui)
          positive_case = true
        }
      }
      if (positive_case) {
        val signsymptom = JCasUtil.select(aJCAS, classOf[SignSymptomMention])
        val signsymptom_array = signsymptom.toArray(new Array[SignSymptomMention](0))


        for (s <- signsymptom_array) {
          var symp_concept = JCasUtil.select(s.getOntologyConceptArr(), classOf[UmlsConcept])
          var symp_concept_array = symp_concept.toArray(new Array[UmlsConcept](0))
          for (sy <- symp_concept_array) {
            println(">>>>>-- symptom cui --->>>>>>> " + sy.getCui)

          }
        }
      }
    }

    // println("------------------- disease or disorder "+diseaseOrDisorders)
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
