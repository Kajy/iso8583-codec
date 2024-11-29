package codec.types.field90

import codec.FieldCodecs.{ localDateFormatter, localTimeFormatter, N }
import scodec.{ Codec, HListCodecEnrichedWithHListSupport, TransformSyntax, ValueCodecEnrichedWithHListSupport }

import java.time.{ LocalTime, MonthDay }

case class OriginalDataElements90(messageId: String, auditNb: String, date: MonthDay, time: LocalTime, organizationId: String, unusedData: String) {
  def toHexString = s"$messageId$auditNb$date$organizationId$unusedData"
}

object OriginalDataElements90 {

  val codec: Codec[OriginalDataElements90] =
    (N(4) ::
      N(6) ::
      N(4).xmapc(MonthDay.parse(_, localDateFormatter))(_.format(localDateFormatter)) ::
      N(6).xmapc(LocalTime.parse(_, localTimeFormatter))(_.format(localTimeFormatter)) ::
      N(12) ::
      N(10))
      .as[OriginalDataElements90]

}
