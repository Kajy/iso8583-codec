package codec.types.field46.field1.types

import codec.FieldCodecs.LLVAR_AN
import codec.types.TokenData4601XX
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.{Codec, TransformSyntax}
import scodec.codecs.mappedEnum

case class TypeData460103(`type`: TypeData460103.Type) extends TokenData4601XX

object TypeData460103 {
  sealed abstract class Type(val value: String) extends StringEnumEntry

  object Type extends StringEnum[Type] {
    val values: IndexedSeq[Type] = findValues

    case object ECOMMERCE extends Type("01")
    case object SECURE_ELEMENT extends Type("02")
    case object CLOUD extends Type("03")
    case object ECOMMERCE_ENABLER extends Type("05")
    case object PSEUDO_ACCOUNT extends Type("06")
    case object HCE extends Type("07")
    case object QCR extends Type("08")
    case object STATIC extends Type("09")

    val mapping: Map[Type, String] =
      Type.valuesToEntriesMap.map(_.swap)
  }

  val tokenTypeCodec: Codec[Type] = mappedEnum(LLVAR_AN, Type.mapping)
  val codec: Codec[TypeData460103] = tokenTypeCodec.as[TypeData460103]
}
