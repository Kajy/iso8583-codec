package codec

import scodec.Transformer
import scodec.bits.BitVector
import shapeless.Generic

object BitMap {
  type RawBitMapField = (BitVector, Option[BitVector])
  type Fields         = Map[Int, Boolean]

  implicit val bitMapTransformer: Transformer[RawBitMapField, Fields] =
    Transformer.fromGeneric(
      Generic.instance(
        b => {
          val bitMap1    = b._1.toIndexedSeq.zipWithIndex.map(t => t._2 + 1 -> t._1)
          val bitMap2Opt = b._2.map(_.toIndexedSeq.zipWithIndex.map(t => t._2 + 65 -> t._1))
          (bitMap2Opt.getOrElse(Nil) ++ bitMap1).toMap
        },
        c => {
          val listMap = c.toList.sortBy(_._1)
          val bitMap1 = listMap.filter(_._1 <= 64).map(_._2)
          val bitMap2 = listMap.filter(_._1 > 64).map(_._2)

          BitVector.bits(bitMap1) -> Option.when(bitMap2.nonEmpty)(
            BitVector.bits(bitMap2)
          )
        }
      )
    )

  implicit class FieldsOps(a: Fields) {
    def isPresent(fieldNb: Int): Boolean = a.getOrElse(fieldNb, false)
  }

}
