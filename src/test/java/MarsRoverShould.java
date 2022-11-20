import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MarsRoverShould {

    private MarsRover marsRover;
    @Mock
    private CommandParser commandParser;
    @Mock
    private CommandFactory commandFactory;
    @Mock
    private Command command;

    @BeforeEach
    public void setUp(){
        marsRover = new MarsRover(commandParser, commandFactory, command);
    }

    @Test
    public void parse_string_command_to_enum(){
        //given
        String command = "R";

        //when
        marsRover.execute(command);

        //then
        then(commandParser).should().parse(command);
    }

    @Test
    public void call_command_factory_return_commands_to_execute(){
        //given
        String command = "R";
        List<CommandType> commandTypeList = List.of(CommandType.ROTATE_RIGHT);
        given(commandParser.parse(command)).willReturn(commandTypeList);

        //when
        marsRover.execute(command);

        //then
        then(commandFactory).should().createCommand(commandTypeList);
    }

    @Test
    public void execute_commands_and_return_the_final_grid(){
        //given
        String commands = "R";
        List<CommandType> commandTypeList = List.of(CommandType.ROTATE_RIGHT);
        List<Command> commandList = List.of(new RotateRight());
        given(commandParser.parse(commands)).willReturn(commandTypeList);
        given(commandFactory.createCommand(commandTypeList)).willReturn(commandList);

        //when
        marsRover.execute(commands);

        //then
        then(command).should().execute();
    }

}