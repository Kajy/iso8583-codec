package codec.types.field46.field4.`type`

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field46.field4.OtherData4604XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.{Codec, TransformSyntax}
import scodec.codecs.*

case class PanSource460403(panSource: PanSource460403.PanSource)
    extends OtherData4604XX

object PanSource460403 {
  sealed abstract class PanSource(val value: String) extends StringEnumEntry

  object PanSource extends StringEnum[PanSource] {
    val values = findValues

    case object CARD_ON_FILE extends PanSource("01")
    case object CARD_ADDED_MANUALLY extends PanSource("02")
    case object CARD_ADDED_APPLICATION extends PanSource("03")
    case object TOKEN_VISA extends PanSource("04")

    val mapping = PanSource.valuesToEntriesMap.map(_.swap)
    val codec = mappedEnum(N, mapping)
  }
  val codec: Codec[PanSource460403] =
    "Pan Source" | LLVAR_N(PanSource.codec).as[PanSource460403]
}
