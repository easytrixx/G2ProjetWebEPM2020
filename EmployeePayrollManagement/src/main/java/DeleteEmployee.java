public class DeleteEmployee implements Command{
    int id;
    @Override
    public void execute() {
        Context.emp.deleteEmployed(id);
    }
    public DeleteEmployee(int id){
        this.id=id;
    }
}
