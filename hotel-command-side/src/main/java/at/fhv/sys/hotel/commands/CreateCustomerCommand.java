package at.fhv.sys.hotel.commands;

public record CreateCustomerCommand(
        String userId,
        String name,
        String email
) {
}
