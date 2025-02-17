package codec.types.field48.types

import codec.FieldCodecs.{LLVAR_N, N}
import codec.types.field48.PrivateData48XX
import codec.types.field48.types.TransportationModeIndicator4838.TransportationModeIndicator
import enumeratum.values.{StringEnum, StringEnumEntry}
import scodec.{Codec, TransformSyntax}
import scodec.codecs.*

case class TransportationModeIndicator4838(mode: TransportationModeIndicator) extends PrivateData48XX

object TransportationModeIndicator4838 {

  sealed abstract class TransportationModeIndicator(val value: String) extends StringEnumEntry

  object TransportationModeIndicator extends StringEnum[TransportationModeIndicator] {
    val values: IndexedSeq[TransportationModeIndicator] = findValues

    case object UNKNOWN                  extends TransportationModeIndicator("00")
    case object URBAN_BUS                extends TransportationModeIndicator("01")
    case object INTERURBAN_BUS           extends TransportationModeIndicator("02")
    case object LIGHT_TRAIN_MASS_TRANSIT extends TransportationModeIndicator("03")
    case object TRAIN                    extends TransportationModeIndicator("04")
    case object COMMUTER_TRAIN           extends TransportationModeIndicator("05")
    case object WATER_BORNE_VEHICLE      extends TransportationModeIndicator("06")
    case object TOLL                     extends TransportationModeIndicator("07")
    case object PARKING                  extends TransportationModeIndicator("08")
    case object TAXI                     extends TransportationModeIndicator("09")
    case object HIGH_SPEED_TRAIN         extends TransportationModeIndicator("10")
    case object RURAL_BUS                extends TransportationModeIndicator("11")
    case object EXPRESS_COMMUTER_TRAIN   extends TransportationModeIndicator("12")
    case object PARA_TRANSIT             extends TransportationModeIndicator("13")
    case object SELF_DRIVE_VEHICLE       extends TransportationModeIndicator("14")
    case object COACH                    extends TransportationModeIndicator("15")
    case object LOCOMOTIVE               extends TransportationModeIndicator("16")
    case object POWERED_MOTOR_VEHICLE    extends TransportationModeIndicator("17")
    case object TRAILER                  extends TransportationModeIndicator("18")
    case object REGIONAL_TRAIN           extends TransportationModeIndicator("19")
    case object INTER_CITY               extends TransportationModeIndicator("20")
    case object FUNICULAR_TRAIN          extends TransportationModeIndicator("21")
    case object CABLE_CAR                extends TransportationModeIndicator("22")
    case object RESERVED23               extends TransportationModeIndicator("23")
    case object RESERVED24               extends TransportationModeIndicator("24")
    case object RESERVED25               extends TransportationModeIndicator("25")
    case object RESERVED26               extends TransportationModeIndicator("26")
    case object RESERVED27               extends TransportationModeIndicator("27")
    case object RESERVED28               extends TransportationModeIndicator("28")
    case object RESERVED29               extends TransportationModeIndicator("29")
    case object RESERVED30               extends TransportationModeIndicator("30")
    case object RESERVED31               extends TransportationModeIndicator("31")
    case object RESERVED32               extends TransportationModeIndicator("32")
    case object RESERVED33               extends TransportationModeIndicator("33")
    case object RESERVED34               extends TransportationModeIndicator("34")
    case object RESERVED35               extends TransportationModeIndicator("35")
    case object RESERVED36               extends TransportationModeIndicator("36")
    case object RESERVED37               extends TransportationModeIndicator("37")
    case object RESERVED38               extends TransportationModeIndicator("38")
    case object RESERVED39               extends TransportationModeIndicator("39")
    case object RESERVED40               extends TransportationModeIndicator("40")
    case object RESERVED41               extends TransportationModeIndicator("41")
    case object RESERVED42               extends TransportationModeIndicator("42")
    case object RESERVED43               extends TransportationModeIndicator("43")
    case object RESERVED44               extends TransportationModeIndicator("44")
    case object RESERVED45               extends TransportationModeIndicator("45")
    case object RESERVED46               extends TransportationModeIndicator("46")
    case object RESERVED47               extends TransportationModeIndicator("47")
    case object RESERVED48               extends TransportationModeIndicator("48")
    case object RESERVED49               extends TransportationModeIndicator("49")
    case object RESERVED50               extends TransportationModeIndicator("50")
    case object RESERVED51               extends TransportationModeIndicator("51")
    case object RESERVED52               extends TransportationModeIndicator("52")
    case object RESERVED53               extends TransportationModeIndicator("53")
    case object RESERVED54               extends TransportationModeIndicator("54")
    case object RESERVED55               extends TransportationModeIndicator("55")
    case object RESERVED56               extends TransportationModeIndicator("56")
    case object RESERVED57               extends TransportationModeIndicator("57")
    case object RESERVED58               extends TransportationModeIndicator("58")
    case object RESERVED59               extends TransportationModeIndicator("59")
    case object RESERVED60               extends TransportationModeIndicator("60")
    case object RESERVED61               extends TransportationModeIndicator("61")
    case object RESERVED62               extends TransportationModeIndicator("62")
    case object RESERVED63               extends TransportationModeIndicator("63")
    case object RESERVED64               extends TransportationModeIndicator("64")
    case object RESERVED65               extends TransportationModeIndicator("65")
    case object RESERVED66               extends TransportationModeIndicator("66")
    case object RESERVED67               extends TransportationModeIndicator("67")
    case object RESERVED68               extends TransportationModeIndicator("68")
    case object RESERVED69               extends TransportationModeIndicator("69")
    case object RESERVED70               extends TransportationModeIndicator("70")
    case object RESERVED71               extends TransportationModeIndicator("71")
    case object RESERVED72               extends TransportationModeIndicator("72")
    case object RESERVED73               extends TransportationModeIndicator("73")
    case object RESERVED74               extends TransportationModeIndicator("74")
    case object RESERVED75               extends TransportationModeIndicator("75")
    case object RESERVED76               extends TransportationModeIndicator("76")
    case object RESERVED77               extends TransportationModeIndicator("77")
    case object RESERVED78               extends TransportationModeIndicator("78")
    case object RESERVED79               extends TransportationModeIndicator("79")
    case object RESERVED80               extends TransportationModeIndicator("80")
    case object RESERVED81               extends TransportationModeIndicator("81")
    case object RESERVED82               extends TransportationModeIndicator("82")
    case object RESERVED83               extends TransportationModeIndicator("83")
    case object RESERVED84               extends TransportationModeIndicator("84")
    case object RESERVED85               extends TransportationModeIndicator("85")
    case object RESERVED86               extends TransportationModeIndicator("86")
    case object RESERVED87               extends TransportationModeIndicator("87")
    case object RESERVED88               extends TransportationModeIndicator("88")
    case object RESERVED89               extends TransportationModeIndicator("89")
    case object RESERVED90               extends TransportationModeIndicator("90")
    case object RESERVED91               extends TransportationModeIndicator("91")
    case object RESERVED92               extends TransportationModeIndicator("92")
    case object RESERVED93               extends TransportationModeIndicator("93")
    case object RESERVED94               extends TransportationModeIndicator("94")
    case object RESERVED95               extends TransportationModeIndicator("95")
    case object RESERVED96               extends TransportationModeIndicator("96")
    case object RESERVED97               extends TransportationModeIndicator("97")
    case object RESERVED98               extends TransportationModeIndicator("98")
    case object RESERVED99               extends TransportationModeIndicator("99")

    val mapping = TransportationModeIndicator.valuesToEntriesMap.map(_.swap)
    val codec   = "TransportationModeIndicator" | mappedEnum(N, mapping)
  }

  val codec: Codec[TransportationModeIndicator4838] = LLVAR_N(TransportationModeIndicator.codec).as[TransportationModeIndicator4838]
}
