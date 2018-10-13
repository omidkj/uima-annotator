import org.apache.uima.fit.factory.{AnalysisEngineFactory, JCasFactory}

object TestAE extends App{
  println("main wroks")
  val jCas = JCasFactory.createJCas
  val analysisEngine = AnalysisEngineFactory.createEngine(
    classOf[QuickAE]
  )
}