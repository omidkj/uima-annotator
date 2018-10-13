import org.apache.ctakes.core.cr.TextReader
import org.apache.uima.fit.factory.{AnalysisEngineFactory, CollectionReaderFactory}
import org.apache.uima.fit.pipeline.SimplePipeline

object TextXMLAE2 extends App {
  val crd = CollectionReaderFactory.createReaderDescription(
    classOf[TextReader],
    TextReader.PARAM_FILES, "notes/test.txt"
  )
  // This is similar to loading an AE engine
  val ae = AnalysisEngineFactory.createEngineDescription(
    "desc.ctakes-clinical-pipeline.desc.analysis_engine.AggregatePlaintextUMLSProcessor"
  )

  val qae = AnalysisEngineFactory.createEngineDescription(
    classOf[QuickAE]
  )

  SimplePipeline.runPipeline(crd,ae,qae)

}
